import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useState } from "react";

export default function ModifyDomian(props) {
  const [program, setProgram] = useState("");
  const [batch, setBatch] = useState("");
  const [capacity, setCapacity] = useState("");
  const [qualification, setQualification] = useState("");
  const [domainId, setDomainId] = useState(undefined);

  async function handleDropdown(e) {
    if (e.target.value !== "default") {
      let json = JSON.parse(e.target.value);
      setProgram(json.program);
      setBatch(json.batch);
      setCapacity(json.capacity);
      setQualification(json.qualification);
      setDomainId(json.domain_id)
    }
  }

  async function handleSubmit(event) {
    event.preventDefault();
    try {
      const domainData = {
        program: program,
        batch: batch,
        capacity: capacity,
        qualification: qualification,
      };
      const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(domainData),
      };
      const response = await fetch(
        "http://localhost:8080/domains/update/"+domainId,
        requestOptions
      );
      const data = await response.json();
      if (data.result === "Success") {
        setProgram("");
        setBatch("");
        setCapacity("");
        setQualification("");
        toast.success("Update Success!", {
          position: "bottom-left",
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
          theme: "dark",
        });

        // update domain list
          let resultJson = data.updatedDomain
          const newData = props.domainList.filter(value => { return value.domain_id !== domainId});
          resultJson.domain_id = domainId
          newData.push(resultJson);
          props.setDomain(newData);
          setDomainId(undefined)


      }

    } catch (error) {
      toast.warn("Invalid Input!", {
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
      <h1> modify Domain </h1>
      <div className="App">
        <form>
          <select
            id="Domains"
            name={program + " " + batch}
            onClick={(e) => {
              handleDropdown(e);
            }}
          >
            {props.domainList.length <= 0 && (
              <option key="default" value="default">
                <>Loading...</>
              </option>
            )}
            {props.domainList.length > 0 &&
              props.domainList.map((item, index) => (
                <option key={index} value={JSON.stringify(item)}>
                  {item.program + " " + item.batch}
                </option>
              ))}
          </select>

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
            Update
          </button>
        </form>
        <ToastContainer />
      </div>
    </div>
  );
}
