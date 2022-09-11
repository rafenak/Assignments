function js_style() {
  document.getElementById("text").style.fontFamily =
    "Impact,Charcoal,sans-serif";
  document.getElementById("text").style.fontSize = "30px";
  document.getElementById("text").style.color = "rgb(172, 221, 222)";
}

function getFormvalue() {
  let form1 = document.getElementById("form1");
  let fname = form1.elements["fname"].value;
  let lname = form1.elements["lname"].value;

  alert(`First Name ${fname} Last Name ${lname}`);
}

function q10c() {
  document.getElementById("q10c").style.backgroundColor = "rgb(172, 221, 222)";
}

function insert_Row() {
  document.getElementById(
    "sampleTable"
  ).innerHTML += `<tr id="3"><td>Row3 cell1</td>  
        <td>Row3 cell2</td></tr>  `;
}
