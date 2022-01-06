let options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
let date = new Date();
let today = date.toLocaleDateString("en-US", options)

// console.log(timeStamp);

$('.date').append(today)