import './App.css';
import Main from './Components/Main/Main.js';
import Footer from './Components/Footer/Footer.js'
import Header from './Components/Header/Header.js';
import { useEffect, useState } from 'react';
import { get } from './http/httpClient';


function App() {
  // For at hente cookies
  const [loggedin, setLoggedin] = useState(false)
  
  useEffect(() => {
    // node js
    // setState ved hjælp af af get fetch fra serverens login 
    get("login", true, 8087).then((response) => {
     response.json().then((e) => {
       console.log(e);
       if (e.loggedIn === true && e.userName != null) {
        isLoggedIn(true)
        
        
       } else {
        isLoggedIn(false)
       }

     });
      
    })
      .catch((e) => {
        console.log("Fejl");
      })
  }
    , [])

  const isLoggedIn = (value) => {
    setLoggedin(value)
  }
  
  return (
    <div className="App">
      <Header loggedin={loggedin} setLoggedin={isLoggedIn} />
      <Main loggedin={loggedin} setLoggedin={isLoggedIn} />
      <Footer />
    </div>
  );
}

export default App;
