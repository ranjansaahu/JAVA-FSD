// Create a list of fruits with their properties (name, color, pricePerKg)
// and convert it into a format so that for a given fruit name
// retrieval of its color and pricePerKg value is fast

// Write your code here
const fruit=[
  {name:'banana',color:'yellow',price:180},
  {name:'cherry',color:'red',price:200},
  {name:'green apple',color:'green',price:70},
  {name:'orange',color:'orange',price:52},
];
const convertToobj=(fruit1,key)=>
fruit1.reduce((obj,item) => {
  obj[item[key]]=item;
  return obj;
}, {});
const fruitobj=convertToobj(fruit,'name');
console.log(fruitobj);
console.log(fruitobj.apple);
console.log(fruitobj.orange);