// Write a program to display one result card of 10 students
// with their name and percentage
// Out of 10 students, 5 has subjects - Grammer and Accounts
// and other 5 has subjects -  Grammer and Physics

// Hint : You need to calculate percentage of 10 students having different set of subjects.
//        You can assume their scores on their respective subjects.

// Write your code here
const results=()=>{
  const student=[
      {name:'div',subjects:[{subject:'Grammer',marks:80},{subject:'Accounts',marks:79}]},
      {name:'moni',subjects:[{subject:'Grammer',marks:45},{subject:'Accounts',marks:98}]},
      {name:'shruti',subjects:[{subject:'Grammer',marks:100},{subject:'Accounts',marks:79}]},
      {name:'kavya',subjects:[{subject:'Grammer',marks:60},{subject:'Accounts',marks:69}]},
      {name:'anjali',subjects:[{subject:'Grammer',marks:28},{subject:'Accounts',marks:53}]},
      {name:'ammu',subjects:[{subject:'Grammer',marks:35},{subject:'Accounts',marks:44}]},
      {name:'akki',subjects:[{subject:'Grammer',marks:43},{subject:'Accounts',marks:90}]}
  ]
  const result=()=>
  student.reduce((obj,item)=>{

      let percenRes=item.subjects.reduce(()=>{
          return (item.subjects[0].marks+item.subjects[1].marks)/item.subjects.length;
      }, {})
      console.log({ 'name':item.name,'percentage':percenRes});
  }, {})
  const finResult=result(student);
  return finResult;
}
results();