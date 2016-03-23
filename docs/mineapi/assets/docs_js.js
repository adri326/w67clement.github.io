var terminal = document.getElementById('terminal');
var rectangle = true;
var text = "$ Loading..."
var seconds = 5;

var terminalTaskId = setInterval(writeInTerminal, 300);
var decrementTaskId = setInterval(decrementSeconds, 1000);

function decrementSeconds() {
    console.log("Seconds: " + seconds);
    seconds--;
    if (seconds == 0) {
        window.location.replace("Home.html");
    }
}

function writeInTerminal() {
    terminal.innerHTML = text + "<br />&nbsp;&nbsp;Redirection in " + seconds + " seconds...";
    if (rectangle) {
        $('.caret').stop().fadeIn(100);
    } else {
        $('.caret').stop().fadeOut(100);
    }
    rectangle = !rectangle;
}
