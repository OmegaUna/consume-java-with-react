window.onload = getAll;
document.getElementById('addnewsitembutton').onclick = add;


let getRandomNewsItemRequest = new XMLHttpRequest();
function getAll () {
    getRandomNewsItemRequest.open("GET", "Controller?command=GetAllNewsItems", true);
    getRandomNewsItemRequest.onreadystatechange = uiLoadNewsItems;
    getRandomNewsItemRequest.send();
}
function uiLoadNewsItems () {
    let container = document.getElementById("container");
    container.innerHTML = "";
    if (getRandomNewsItemRequest.readyState == 4) {
        if (getRandomNewsItemRequest.status == 200) {
            let data = JSON.parse(getRandomNewsItemRequest.responseText);
            console.log(data);
            data = data.map((x) => `<h2>${x.title}</h2><p>${x.text}</p><p>Posted on ${x.created_at}</p><p>By: ${x.author}</p>`);
            console.log(data);
            for (newsItem of data) container.innerHTML += `<div>${newsItem}</div>`;
        } else {
            container.appendChild(document.createTextNode("Something went wrong.."));
        }
    } else {
        container.appendChild(document.createTextNode("Loading.."));
    }
}


function add () {
    let addNewsItemRequest = new XMLHttpRequest();
    let title = document.getElementById("newsitemTitle").value;
    let author = document.getElementById("newsitemAuthor").value;
    let text = document.getElementById("newsitemText").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    let information = "title=" + encodeURIComponent(title)+"&author="+ encodeURIComponent(author) + "&text=" + encodeURIComponent(text);
    addNewsItemRequest.open("POST", "Controller?command=AddNewsItem", true);
    addNewsItemRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addNewsItemRequest.send(information);
    getAll();
}
