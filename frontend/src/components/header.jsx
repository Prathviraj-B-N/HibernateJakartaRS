import '../css/header.css'

export default function Header(props){
    let showLogout = <></>
    if(props.login === true) 
        showLogout = <li onClick={() => props.setlogin(false)}>Logout</li>
    return(
    <div className='headerzdiv'>
        <ul>
            <li>
                Academic ERP
            </li>
            {showLogout}
            
         </ul>
    </div> );
        
}