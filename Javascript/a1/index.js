/* Type conversion
let num = "1";
num = Number(num);
num = String(num);
if not number = NaN
if empty = false
*/


let name,age;

function error(params) {
    document.getElementById("out").innerText = "Please enter valid "+params;
    
}

document.getElementById("mybutton").onclick = function() {
    name = document.getElementById("name").value;
    age = document.getElementById("age").value;
    age = Number(age)
    if (name == "" && age == 0) {
        error("Name & Age");
        
    } else if (String(age) == "NaN") {
        error("Age");
    } else if(age >= 100) {
        document.getElementById("out").innerText = "Hello "+name+" You are too old to type.";
        
    } else {
        document.getElementById("out").innerText = "Hello "+name+" You are "+age+" years old";
        
    }
}
