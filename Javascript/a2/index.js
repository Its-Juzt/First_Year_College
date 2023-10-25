let num;

num = document.getElementById("num").innerHTML;
num = Number(num);

document.getElementById("dec").onclick = function() {
    num = num -= 1;
    document.getElementById("num").innerText = num;
}

document.getElementById("reset").onclick = function() {
    document.getElementById("num").innerText = 0;
    num = 0;

}

document.getElementById("inc").onclick = function() {
    document.getElementById("num").innerText = num += 1;

}
