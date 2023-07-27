
document.addEventListener("DOMContentLoaded", async () => {
  try {
    const result = await fetch('http://localhost:8080/stat/1', {
      mode: "cors",
      headers: {
        Accept: "application/json",
      },
    });
    data = await result.json();
  } catch (error) {
    console.error(error);
  }
  const table = document.getElementById("table-body");

    for (var i = 0; i < data.length; i++)
    {
    	//Add the data row.
    	var row = table.insertRow(-1);

    	//Add the data cells.
    	var cell = row.insertCell(-1);
    	cell.innerText = data[i].stat.question;

    	cell = row.insertCell(-1);
    	cell.innerText = data[i].userChoice;

    	cell = row.insertCell(-1);
    	cell.innerText = data[i].stat.totalA;

    	cell = row.insertCell(-1);
    	cell.innerText = data[i].stat.totalB;
    }
});