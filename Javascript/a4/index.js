

const ranint = Math.floor(Math.random() * 15 + 1)

document.getElementById("submit").onclick = function() {
    setTimeout(1000);
    let input = document.getElementById("guess").value;
    input = Number(input);
    if (input.toString() == "NaN" || input == "" || input == 0) {
        document.getElementById("output").innerHTML = "<label>Not even close.</label>";
        reset();
    } else if (input < ranint) {
        document.getElementById("output").innerHTML = "<label>Your number is smaller.</label>";
        reset();
    } else if (input > ranint && ranint < 15) {
        document.getElementById("output").innerHTML = "<label>Your number is larger.</label>";
        reset();
    } else if (input > 15) {
        document.getElementById("output").innerHTML = "<label>Your number is too large</label>";
        reset();
    } else if (input == ranint) {
        document.getElementById("output").innerHTML = '<label style="color:green;font-size: 35px;">You won!</label><br>\
<button onclick="document.location=\'\/index.html\'" value="player" type="button" style="font-size: 15px;height: 28px;width: 16ch;margin-top:15px;background-color:black;border-color:green;color:green">Play again</button>'
    }
}


function reset() {
    setTimeout(()=> {
    document.getElementById("output").innerHTML = ""
    },3000);
}
