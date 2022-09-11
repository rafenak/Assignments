function q1a(){

let v1 = 10;
let v2 = 20;

let add = (v1, v2) => {
  return v1 + v2;
};

document.getElementById("q1a").innerHTML=`<p class="fw-light text-break" id="q1a">Addition of number ${v1} and ${v2} := ${add(v1, v2)}</p>`;
//document.write(`<h5 class="fw-light text-break" id="q1a">Addition of number ${v1} and ${v2} := ${add(v1, v2)}</h5>`);
}

function q1b(){
let areaOfTriangle = (s1, s2, s3) => {
  let s = (s1 + s2 + s3) / 2;
   let area = Math.sqrt(s * ((s - s1) * (s - s2) * (s - s3)));
  return area
};

let p = document.getElementById("q1b");
p.innerHTML=`Area of Trainagle size 5,6,7 := ${areaOfTriangle(5,6,7)}`
}
