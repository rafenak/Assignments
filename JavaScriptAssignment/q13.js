function q13a(){
    let str = prompt("Enter any String");
    let char1=str.charAt(0);
    let regexp = /^[A-Z]/;
    if(regexp.test(str))
    document.getElementById("q13a").innerHTML = `first character "${char1}" of a string ${str} is uppercase`;
    else
    document.getElementById("q13a").innerHTML = `first character "${char1}"  of a string ${str} is not uppercase`;
}

function q13b(){
    let str = prompt("Enter credit card number");
    let regexp = /\d{4}-\d{4}-\d{4}-\d{4}/;
    if(regexp.test(str))
    document.getElementById("q13b").innerHTML = `Credit card number ${str} is in correct format`;
    else
    document.getElementById("q13b").innerHTML = `Credit card number ${str} is not in correct format`;
}

function q13c(){
    let str = prompt("Enter Email Address");
    let regexp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
    if(regexp.test(str))
    document.getElementById("q13c").innerHTML = `Email Address ${str} is in correct format`;
    else
    document.getElementById("q13c").innerHTML = `Email Address ${str} is not in correct format`;     
}