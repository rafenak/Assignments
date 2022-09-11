function q6a() {
  let num = parseInt(prompt("Enter any number "));
  let res = num % 2 ? "even" : "odd";
  document.getElementById("q6a").innerHTML = `Your number ${num} is ${res}`;
}

function q6b() {
  let price = [22.5, 44.5, 9.98];
  let product = ["1", "2", "3"];
  let quantity = [];

  let productnumber = document.getElementById("productnumber").value;
  let qty = document.getElementById("quantity").value;

  let sum = 0;

  for (let i = 0; i < product.length; i++) {
    switch (productnumber) {
      case "1":
        sum = price[0] * qty;
        break;
      case "2":
        sum = price[1] * qty;
        break;
      case "3":
        sum = price[2] * qty;
        break;
      default:
        break;
    }
  }
  document.getElementById(
    "q6b"
  ).innerHTML = `Total retail value of all products sold is ${sum}`;
}

function q6c() {
  let num = parseInt(prompt("Enter any number "));
  document.getElementById("q6c").innerHTML = "";
  for (let index = 1; index <= 20; index++) {
    let ans = index * num;
    document.getElementById(
      "q6c"
    ).innerHTML += `${num} * ${index}= ${ans} </br>`;
  }
}

function q6d() {
  let num = parseInt(prompt("Enter any number "));
  if (num === 0)
    document.getElementById("q6d").innerHTML = `The factorial of ${num} is 1`;
  else {
    let fact = 1;
    for (let index = 1; index <= num; index++) {
      fact *= index;
    }
    document.getElementById(
      "q6d"
    ).innerHTML = `The factorial of ${num} is ${fact}`;
  }
}

function q6e() {
  document.getElementById("q6c").innerHTML = "";
  document.getElementById("q6e").innerHTML = `divisible by 7 between 200 and 300 = </br>`;
  for (let index = 200; index <= 300; index++) {
    if (index % 7 == 0) {
      document.getElementById("q6e").innerHTML += `${index}</br>`;
    }
  }
}
