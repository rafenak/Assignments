function q8a() {
  let currDate = new Date();
  let agent = window.navigator.userAgent;
  document.getElementById(
    "q8a"
  ).innerHTML = `Current Date Format ${currDate} in browerser ${agent}`;
}

function q8b() {
  let currDate = new Date();
  let fullY = currDate.getFullYear();
  let y = currDate.getYear();
  document.getElementById(
    "q8b"
  ).innerHTML = `Full Year formar ${fullY} and Year formar ${y}`;
}

function q8c() {
  let d = new Date();
  let ye = new Intl.DateTimeFormat("en", { year: "numeric" }).format(d);
  let mo = new Intl.DateTimeFormat("en", { month: "long" }).format(d);
  let da = new Intl.DateTimeFormat("en", { day: "2-digit" }).format(d);
  document.getElementById("q8c").innerHTML = `${mo}/${da}/${ye}`;
}

function q8d() {
  let d = new Date();
  let ye = new Intl.DateTimeFormat("en", { year: "numeric" }).format(d);
  let mo = new Intl.DateTimeFormat("en", { month: "long" }).format(d);
  let da = new Intl.DateTimeFormat("en", { day: "2-digit" }).format(d);
  let hrs = new Intl.DateTimeFormat("en", { hour: "2-digit" }).format(d);
  let min = new Intl.DateTimeFormat("en", { minute: "numeric" }).format(d);
  document.getElementById("q8d").innerHTML = `${mo}/${da}/${ye} ${hrs}:${min}`;
}

function q8e() {
  let num = parseInt(prompt("Enter number between 1 and 10"));
  let rand = (min, max) => {
    let rand = Math.floor(Math.random() * (max - min + 1)) + min;
    return rand;
  };
  let randnumber = rand(2, 10);
  if (num === randnumber) {
    alert(
      `Guess is correct! Your choice is ${num} Random number was ${randnumber}`
    );
  } else {
    alert(
      `Guess is wrong! Your choice is ${num} Random number was ${randnumber}`
    );
  }
}

function q8f() {
  let d = new Date();
  let ye = new Intl.DateTimeFormat("en", { year: "2-digit" }).format(d);
  let mo = new Intl.DateTimeFormat("en", { month: "long" }).format(d);
  let da = new Intl.DateTimeFormat("en", { day: "2-digit" }).format(d);
  let time = new Intl.DateTimeFormat("en", {
    hour: "numeric",
    minute: "numeric",
    hour12: true,
  }).format(d);
  document.getElementById("q8f1").innerHTML = `${mo} ${da} ,${ye}`;
  document.getElementById("q8f2").innerHTML = `${mo} ${da}/${ye} ${time}`;
}

function q8g() {
  let str = prompt("Enter any String");
  let ans = str
    .split("")
    .map((c) => (c === c.toUpperCase() ? c.toLowerCase() : c.toUpperCase()))
    .join("");
  document.getElementById("q8g").innerHTML = `Before= ${str}  After= ${ans}`;
}

function q8h() {
    let str = prompt("Enter any String");
    let char1=str.charAt(0);
    if(char1===char1.toUpperCase())
    document.getElementById("q8h").innerHTML = `first character "${char1}" of a string ${str} is uppercase`;
    else
    document.getElementById("q8h").innerHTML = `first character "${char1}"  of a string ${str} is not uppercase`;
   
}

function q8i(){
    let student = { name : "David Rayy", sclass : "VI", rollno : 12 };
    document.getElementById("q8i").innerHTML=''
    for (const key in student) {
        document.getElementById("q8i").innerHTML+= `${key} \n`;
    } 
}

function q8j(){
    let library = [ 
	    {
	        title: 'Bill Gates',
	       author: 'The Road Ahead',
	        readingStatus: true
	    },
	    {
	        title: 'Steve Jobs',
	        author: 'Walter Isaacson',
	       readingStatus: true
	    },
	    {
	        title: 'Mockingjay: The Final Book of The Hunger Games',
	        author: 'Suzanne Collins',
	        readingStatus: false
	    }];
        document.getElementById("q8j").innerHTML=''

      for (const iterator of library) {
        document.getElementById("q8j").innerHTML+= `Title: ${iterator.title} 
                                                    \n Author: ${iterator.author} 
                                                    \n ReadStatus: ${iterator.readingStatus} \n`;
      }  

}
