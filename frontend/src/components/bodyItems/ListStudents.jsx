import { useState } from "react";
import { ToastContainer,toast } from "react-toastify";
import "../../css/listStudents.css";
import Student from "../Student";

const ListStudents = (props) => {

  const [studentList, setStudentList] = useState([]);

  function handleGetStudents(e) {
    e.preventDefault();
    if (e.target.value !== "default") {
      fetch(`http://localhost:8080/student/getStudent/` + JSON.parse(e.target.value).domain_id)
        .then((response) => {
          if (!response.ok) {
            throw new Error(
              `This is an HTTP error: The status is ${response.status}`
            );
          }
          return response.text();
        })
        .then((actualData) => {
          setStudentList(JSON.parse(actualData));
        })
        .catch(() => {
          toast.warn('Invalid Input!', {
            position: "bottom-right",
            autoClose: 2000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "dark",
            });
          setStudentList(null);
        });
    } else {
      toast.warn('Enter Domain ID from the list!', {
        position: "bottom-right",
        autoClose: 2000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "dark",
        }); 
    }
  }

  return (
    <div className="bodySections">
      <h1>Student List</h1>

    <div className="App">
    <form>
          <select
            id="Domains"
            name='program batch'
            onClick={(e) => {
              handleGetStudents(e);
            }}
          >
            {props.domainList.length <= 0 && (
              <option key="default" value="default">
                Loading...
              </option>
            )}
            {props.domainList.length > 0 &&
              props.domainList.map((item, index) => (
                <option key={index} value={JSON.stringify(item)}>
                  {item.program + " " + item.batch}
                </option>
              ))}
          </select>
        </form>
      <div className="studentDisplay">
      {studentList.map((content) => (
          <Student content={content} key={content.rollNumber} />
        ))}
      </div>         
      
    </div>

      
      <ToastContainer/>
    </div>
  );
}

export default ListStudents;