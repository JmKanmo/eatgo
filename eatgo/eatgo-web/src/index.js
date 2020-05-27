(async () => {
    const url = 'http://localhost:5000/restaurants/';
    const response = await fetch(url);
    const data = await response.json();
    const app = document.querySelector(".app");

    data.forEach(e => {
        app.innerHTML += `<p> 
    ${e.id}
    ${e.name}
    ${e.location} 
    </p>
    `;
    });
})();
