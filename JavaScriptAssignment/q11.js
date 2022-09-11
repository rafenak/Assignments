function q11() {
  let txtinput = document.getElementById("txtinput").value;
  let msg = document.getElementById("q11");
  try {
    if (txtinput === "") throw "Is Empty";
    if (isNaN(txtinput)) throw "Not a Number";
    if (txtinput > 10) throw "Too High value";
    if (txtinput < 5) throw "Too low value";
    if(txtinput >=5 && txtinput <=10) throw "Value is valid"
   } catch (error) {
    msg.innerHTML = `${txtinput} input is ` + error;
  } finally {
    document.getElementById("txtinput").value = "";
  }
}
