import { useState } from "react";

import "../../css/addDomain.css";
import { toast,ToastContainer } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

export default function AddDomain() {
  const [program, setProgram] = useState("");
  const [batch, setBatch] = useState("");
  const [capacity, setCapacity] = useState("");
  const [qualification, setQualification] = useState("");

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      const formData = {
        program: program,
        batch: batch,
        capacity: capacity,
        qualification: qualification,
      };
      const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      };
      const response = await fetch(
        "http://localhost:8080/domains/add",
        requestOptions
      );
      const data = await response.json();
      if (data["result"] === "Success") {
        setProgram("");
        setBatch("");
        setCapacity("");
        setQualification("");
        toast.success('Add Success!', {
          position: "bottom-left",
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          theme: "dark",
          });
      }
      
    } catch (error) {
      toast.warn('Invalid Input!', {
        position: "bottom-left",
        autoClose: 2000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "dark",
        });
        setProgram("");
        setBatch("");
        setCapacity("");
        setQualification("");
    }
  }

  return (
    <div className="bodySections">
      <h1> Add Domain </h1>
      <div className="App">
        <form>
          <input
            type="text"
            value={program}
            placeholder="Program"
            onChange={(e) => setProgram(e.target.value)}
          />

          <input
            type="text"
            value={batch}
            placeholder="Batch"
            onChange={(e) => setBatch(e.target.value)}
          />

          <input
            type="text"
            value={capacity}
            placeholder="Capacity"
            onChange={(e) => setCapacity(e.target.value)}
          />

          <input
            type="text"
            value={qualification}
            placeholder="Qualification"
            onChange={(e) => setQualification(e.target.value)}
          />

          <button type="submit" onClick={(event) => handleSubmit(event)}>
            Add
          </button>
        </form>
        <ToastContainer />
      </div>

    </div>
  );
}
