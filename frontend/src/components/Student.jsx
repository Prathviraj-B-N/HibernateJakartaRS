
export default function Student(props){

    return(
        <div className="studentCard">
            <li>Name : {props.content.firstName} {props.content.lastName}</li><br/>
            <li>Roll Number : {props.content.rollNumber}</li>
        </div>
    );
}