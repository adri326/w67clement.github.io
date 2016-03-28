// Prism.js injector for forums.
var prismCss = document.createElement("link");
prismCss.setAttribute('rel', 'stylesheet');
prismCss.setAttribute('href', 'https://w67clement.github.io/prism.css');

var prismJs = document.createElement("script");
prismJs.setAttribute('src', 'https://w67clement.github.io/prism.js');

$('head').append(prismCss);
$('body').append(prismJs);
