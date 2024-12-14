// Sample data for festival details
const festivalDetails = {
    Diwali: {
        rituals: "Diwali involves cleaning homes, lighting lamps, and exchanging sweets.",
        cultural: "It marks the victory of light over darkness and good over evil.",
        states: "Celebrated all over India, especially in Uttar Pradesh, Rajasthan, and Gujarat.",
        date: "Typically falls in October or November, depending on the lunar calendar."
    },
    Holi: {
        rituals: "Holi involves throwing colored powders and singing songs.",
        cultural: "It celebrates the arrival of spring and the victory of good over evil.",
        states: "Mainly celebrated in Uttar Pradesh, Maharashtra, and Rajasthan.",
        date: "Usually celebrated in March."
    },
    Navratri: {
        rituals: "Navratri involves fasting, prayers, and the Durga Puja celebrations.",
        cultural: "It celebrates the victory of goddess Durga over the buffalo demon Mahishasura.",
        states: "Predominantly celebrated in Gujarat, Maharashtra, and West Bengal.",
        date: "Usually falls in September or October."
    },
    Ugadi: {
        rituals: "Ugadi involves cleaning homes, cooking traditional dishes, and offering prayers.",
        cultural: "It marks the start of a new year in the Hindu lunar calendar, especially in South India.",
        states: "Mainly celebrated in Karnataka, Andhra Pradesh, and Telangana.",
        date: "Usually falls in March or April."
    },
    'Makar Sankranthi': {
        rituals: "It involves flying kites, taking holy dips in rivers, and offering prayers.",
        cultural: "It marks the transition of the sun into the zodiac sign of Capricorn.",
        states: "Celebrated in Punjab, Gujarat, Maharashtra, and Tamil Nadu.",
        date: "Typically falls on January 14th."
    },
    'Ganesh Chaturthi': {
        rituals: "It involves installing Ganesha idols, performing prayers, and immersing the idols in water.",
        cultural: "It celebrates the birth of Lord Ganesha.",
        states: "Mainly celebrated in Maharashtra, Gujarat, and Karnataka.",
        date: "Usually falls in August or September."
    }
};

// Function to display festival details in the modal
function showDetails(idName) {
    const modalBody = document.getElementById("modalBodyHistory");

    // Get the festival details
    // const details = festivalDetails[festival];
    dataToPrint = document.getElementById(idName).value;


    // Check if the requested details exist
    if (dataToPrint) {
        // Display the appropriate detail in the modal
        modalBody.innerHTML = `<strong>History : </strong> ${dataToPrint}`;
    } else {
        modalBody.innerHTML = "<strong>No details available for this festival.</strong>";
    }
}

function exploreImages(idName) {
    console.log("ID Received:", idName); // Debugging

    const button = document.getElementById(idName);
    if (!button) {
        console.error(`Button with ID ${idName} not found`);
        return; // Exit if button is not found
    }

    const rawData = button.getAttribute('data-images');
    console.log("Raw Data:", rawData);

    const imageList = rawData.split(',');


    // let imageList;
    // try {
    //     // Parse the raw data as JSON
    //     imageList = JSON.parse(rawData);
    // } catch (error) {
    //     console.error("Failed to parse JSON:", error.message);
    //     imageList = []; // Default to empty array if parsing fails
    // }

    const modalBody = document.getElementById("modalBody");
    if (imageList && Array.isArray(imageList)) {
        modalBody.innerHTML = ""; // Clear previous content
        imageList.forEach((image, index) => {
            modalBody.innerHTML += `<img src="${image}" alt="Image ${index + 1}" class="img-fluid mb-2">`;
        });
    } else {
        modalBody.innerHTML = "<strong>No images available for this monument.</strong>";
    }
}

