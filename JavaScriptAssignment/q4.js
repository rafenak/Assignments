function q4(){
    let fn;
    let nextfn;
    fn=parseInt(prompt("Enter favorite number "));
    nextfn=parseInt(prompt("Enter next favorite number "));
    let sum=fn+nextfn;
    document.getElementById("q4").innerHTML=`You numbers ${fn} and ${nextfn} added together are ${sum} `
}