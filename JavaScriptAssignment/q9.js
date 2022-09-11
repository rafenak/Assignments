function q9a() {
  let array = [3, "a", "a", "a", 2, 3, "a", 3, "a", 2, 4, 9, 3];
  let maxCount = 0;
  let maxEle;
  for (let i = 0; i < array.length; i++) {
    let cnt = 0;
    for (let j = 0; j < array.length; j++) {
      if (array[i] == array[j]) {
        cnt += 1;
      }
    }
    if (cnt > maxCount) {
      maxCount = cnt;
      maxEle = array[i];
    }
  }
  document.getElementById("q9a").innerHTML = `Most frequent item of an array [${array}] is "${maxEle}"`;
}

function q9b() {
  let myColor = ["Red", "Green", "White", "Black"];
  let str1 = myColor.join(",");
  let str2 = myColor.join("+");
  document.getElementById(
    "q9b"
  ).innerHTML = `1st Join ${str1} \n 2nd Join ${str2}`;
}

function q9c() {
  let array = [1, 2, 3, 4, 5, 6];
  let sum = 0;
  array.forEach((element) => {
    sum += element;
  });
  document.getElementById(
    "q9c"
  ).innerHTML = `The sum of Array [${array}] is ${sum}`;
}

function q9d() {
  let array1 = [3, 8, 7, 6, 5, -4, -3, 2, 1];
  let array = [3, 8, 7, 6, 5, -4, -3, 2, 1];
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length; j++) {
      if (array[i] < array[j]) {
        let temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
  }
  document.getElementById("q9d").innerHTML = `Sort of [${array1}] is [${array}] `;
}


function q9e(){
    let array=[1,2,2,3,4,6,8,7,8];
    array.sort()
    let array1=[]
    for (let i = 0; i < array.length; i++) {
        if(!(array[i]===array[i+1])){
            array1.push(array[i])
        }
    }
    document.getElementById("q9e").innerHTML = `Remove duplicate of [${array}] is [${array1}] `;

}