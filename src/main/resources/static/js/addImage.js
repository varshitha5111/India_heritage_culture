
let counter = 0;

function addtextbox(length) {
    counter = length; // Increment the counter for each new input
    const linkDiv = document.getElementById("link");
    // Create a new input field
    const newInput = document.createElement("input");
    newInput.type = "url";
    newInput.className = "form-control my-1";
    newInput.id = `image-${counter}`;
    newInput.name = `imageList[${counter}]`;
    newInput.placeholder = "Enter the specific location";
    newInput.required = true;

    // Append the new input to the div
    linkDiv.appendChild(newInput);
}

function url_change(idName, value) {
    console.log("URL Changed:", value);
    // console.log("Index:", index);
    console.log("ID:", idName);
    if (value == "") {
        console.log("helloo");
        const element = document.getElementById(idName);
        element.remove();
    }
}
