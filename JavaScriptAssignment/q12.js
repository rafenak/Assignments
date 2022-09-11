function diplayText(){
    let s =document.getElementById('s').value
    document.getElementById('d').innerText=s
    document.getElementById('s').value=''
}

function reset(){
    document.getElementById('s').value=''
    document.getElementById('d').value=''
}

window.onload = function() {
    document.getElementById("s").focus();
  };