function q3(){
    let fName='Rafe';
    let lName='Nakhuda'
    let fullName= fName+' '+lName;
    fName=prompt("Enter first name ",fName)
    lName=prompt("Enter Last name ",lName)
    fullName= fName+' '+lName;
    document.getElementById("q3").innerHTML=`Hello ${fullName} Welcome to my page!`
}