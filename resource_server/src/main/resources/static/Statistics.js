var table = document.getElementById("table-body");
const stats = [
   {
      "Question":1,
      "Choice":"A",
      "NoAs":30,
	  "NoBs":70
   },
   {
      "Question":2,
      "Choice":"B",
      "NoAs":40,
	  "NoBs":60
   },
   {
      "Question":3,
      "Choice":"A",
      "NoAs":45,
	  "NoBs":55
   },
   {
      "Question":4,
      "Choice":"B",
      "NoAs":90,
	  "NoBs":10
   }
];

for (var i = 0; i < stats.length; i++) 
{
	//Add the data row.
	var row = table.insertRow(-1);
 
	//Add the data cells.
	var cell = row.insertCell(-1);
	cell.innerText = stats[i].Question;
 
	cell = row.insertCell(-1);
	cell.innerText = stats[i].Choice;
 
	cell = row.insertCell(-1);
	cell.innerText = stats[i].NoAs;

	cell = row.insertCell(-1);
	cell.innerText = stats[i].NoBs;
}