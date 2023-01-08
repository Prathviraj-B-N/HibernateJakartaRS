import ModifyDomian from "./body/ModifyDomain";
import AddDomain from "./body/AddDomain";
import ListStudents from "./body/ListStudents";

import "../css/body.css";

import { useState, useEffect } from "react";
import { ToastContainer, toast } from "react-toastify";
export default function Body() {
  const [Domain, setDomain] = useState([]);

  useEffect(() => {
    fetch(`http://localhost:8080/domains`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `This is an HTTP error: The status is ${response.status}`
          );
        }
        return response.text();
      })
      .then((actualData) => {
        setDomain(JSON.parse(actualData));
      })
      .catch((err) => {
        toast.warn("Error In Populating Dropdown!", {
          position: "bottom-right",
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          theme: "dark",
        });
        setDomain(null);
      });
  }, []);

  return (
    <div className="body">
      <AddDomain />
      <ModifyDomian domainList={Domain} setDomain={setDomain} />
      <ListStudents domainList={Domain} />
      <ToastContainer />
    </div>
  );
}
