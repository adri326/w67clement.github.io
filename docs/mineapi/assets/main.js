/*
 * Copyright (c) 2016 Adrien Navratil
 *
 * This file is part of Fishdoc.
 *
 * Fishdoc is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Fishdoc is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Fishdoc.  If not, see <http://www.gnu.org/licenses/>.
 */

function dynamicList(id)
{
    var list = document.getElementById(id);
    var li = list.getElementsByTagName('li');
    var i;

    for(i = 0; i < li.length - 1; i++)
    {
        var childList = li[i].getElementsByTagName('ul');

        if (childList[0])
        {
            childList[0].id = id + i;
            childList[0].style.display = 'none';

            li[i].getElementsByTagName('a')[0].href = 'javascript:showList(' + i + ')';
        }
    }
}

function showList(i)
{
    var id = 'tree' + i;
    var child = document.getElementById(id);
    var li = child.getElementsByTagName('li');

    if (li[0])
        for(var int = 0; int < li.length; int++)
            if (id != 'tree')
                li[int].style.marginLeft = '5px';

    if (child.style.display == 'block' || child.style.display == null)
        child.style.display = 'none';
    else
        child.style.display = 'block';
}

function showPrevious(previousPage)
{
    var allA = document.getElementsByTagName("a");

    for (var i = 0, l = allA.length; i < l; i++)
    {
        var a = allA[i];

        if (a.href.indexOf(previousPage) > -1)
        {
            showParentList(a.parentNode.parentNode);
            break;
        }
    }
}

function showParentList(node)
{
    var id = node.id;

    if (id == 'tree')
        return;

    showList(id.substring(id.length - 1));

    var parentOfParent = node.parentNode.parentNode;
    if (parentOfParent.tagName == 'UL')
        showParentList(parentOfParent);
    else
        console.log('It is not ul');
}

var init = function()
{
    dynamicList('tree');

    if (location.search != '')
        showPrevious(location.search.substring(1));

    var tree = document.getElementById("main-tree");
    tree.style.height = document.getElementById('content').clientHeight + 'px';
};

window.onload = init;