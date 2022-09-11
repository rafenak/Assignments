function q5() {
  let num = parseInt(prompt("Enter Number ", 0));

  if (num < 100 && num > 30 && num < 70) {
    document.getElementById(
      "q5"
    ).innerHTML = `You number ${num} is <100, but in between 30 and 70`;
  } else if (num < 100 && num > 10) {
    document.getElementById(
      "q5"
    ).innerHTML = `You number ${num} is between 10 and 100`;
  } else if (num > 100 || num < 10) {
    document.getElementById(
      "q5"
    ).innerHTML = `You number ${num} is not less than 10 or greater than 100`;
  }
}
