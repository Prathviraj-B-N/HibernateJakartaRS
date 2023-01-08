import '../css/header.css'

export default function Header({login , setlogin}){
    
    return(
    <div className='headerzdiv'>
        <ul>
            <li>
                Academic ERP
            </li>
            {login ? (<li onClick={() => setlogin(false)}>Logout</li>) : null}
            
         </ul>
    </div> );
        
}