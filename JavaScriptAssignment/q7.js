function q7a() {
  const isPrime = (num) => {
    if (num <= 1) return false;
    if (num % 2 == 0 && num > 2) return false;
    const s = Math.sqrt(num);
    for (let i = 3; i <= s; i += 2) {
      if (num % i === 0) return false;
    }
    return true;
  };

  let num = parseInt(prompt("Enter any number "));

  if (isPrime(num))
    document.getElementById("q7a").innerHTML = `Your number ${num} is Prime`;
  else
    {document.getElementById("q7a").innerHTML = `Your number ${num} not a Prime`;}
}

function q7b() {
    

    let add=(num1,num2) =>{
        return num1+num2;
    }

    let num1 = parseInt(prompt("Enter 1st number "));
    let num2 = parseInt(prompt("Enter 2nd number "));

    document.getElementById("q7b").innerHTML = `Addition of two numer ${num1}, ${num2} = ${add(num1,num2)}`;


}
