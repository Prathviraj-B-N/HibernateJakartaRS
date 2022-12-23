import '../css/common.css'
import '../css/HomePage.css'

import Header from './header'
import Body from './body'
import Login from './Login'

import { useState } from "react";

export default function HomePage(){
    const [login, setlogin] = useState(false);
    

    
        if(login === true){
            return <div> <Header setlogin={setlogin} login={login}/> <Body/> </div>
        }
        else{
            return <div > <Header setlogin={setlogin}/> <Login setlogin={setlogin}/> </div>
        }
}