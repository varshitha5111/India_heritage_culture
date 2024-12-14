// Log which sidebar link is clicked
document.querySelectorAll('#sidebar .nav-link').forEach(item => {
  item.addEventListener('click', event => {
    console.log(`${item.textContent} clicked`);

    // Hide all sections
    document.querySelectorAll('main > section').forEach(section => {
      section.style.display = 'none';
    });

    // Show the corresponding section based on the clicked link
    if (item.textContent.trim() === 'Food Cuisine') {
      document.getElementById('food-form').style.display = 'block';
    } else if (item.textContent.trim() === 'Dashboard') {
      document.getElementById('dashboard').style.display = 'block';
    }
    // Add more conditions here if you have additional sections
  });
});
// Log which sidebar link is clicked
document.querySelectorAll('#sidebar .nav-link').forEach(item => {
  item.addEventListener('click', event => {
    console.log(`${item.textContent} clicked`);

    // Hide all sections
    document.querySelectorAll('main > section').forEach(section => {
      section.style.display = 'none';
    });

    // Show the corresponding section based on the clicked link
    if (item.textContent.trim() === 'Food Cuisine') {
      document.getElementById('food-form').style.display = 'block';
    } else {
      // Show other sections if needed (e.g., Dashboard or others)
      document.getElementById('dashboard').style.display = 'block';
    }
  });
});

// Function to preview image in Food Form
function previewImage(event) {
  const imagePreview = document.getElementById('imagePreview');
  const reader = new FileReader();

  reader.onload = function () {
    imagePreview.src = reader.result;
    imagePreview.style.display = 'block';
  };

  reader.readAsDataURL(event.target.files[0]);
}

// Function to preview image in Food Form
function previewImage(event) {
  const imagePreview = document.getElementById('imagePreview');
  const reader = new FileReader();

  reader.onload = function () {
    imagePreview.src = reader.result;
    imagePreview.style.display = 'block';
  };

  reader.readAsDataURL(event.target.files[0]);
}

function previewImage(event) {
  const file = event.target.files[0];
  if (file && file.type.startsWith('image/')) {
    const imagePreview = document.getElementById('imagePreview');
    imagePreview.src = URL.createObjectURL(file);
    imagePreview.style.display = 'block';
  } else {
    alert('Please select a valid image file.');
    event.target.value = '';
  }
}
function submitForm() {
  const foodImage = document.getElementById('foodImage').files[0];
  const foodName = document.getElementById('foodName').value;
  const foodState = document.getElementById('foodState').value;
  const foodDescription = document.getElementById('foodDescription').value;
  const foodRecipe = document.getElementById('foodRecipe').value;
  const foodBenefits = document.getElementById('foodBenefits').value;


  const foodImageName = foodImage ? foodImage.name : "No image selected";

  if (foodName && foodState !== 'Choose...' && foodDescription && foodRecipe && foodBenefits) {
    alert('Form submitted successfully!');
  }
  else {
    alert('Please fill out all fields.');
  }
  alert("Food Details Submitted:\n" +
    "Image: " + foodImageName + "\n" +
    "Name: " + foodName + "\n" +
    "State: " + foodState + "\n" +
    "Description: " + foodDescription + "\n" +
    "Recipe: " + foodRecipe + "\n" +
    "Benefits: " + foodBenefits);
}

 