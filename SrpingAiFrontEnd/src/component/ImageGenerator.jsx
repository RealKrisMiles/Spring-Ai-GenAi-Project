import React, { useState } from "react";

function ImageGenerator(){
    const[promt,setPromt] =useState('')
    const[imgUrls,setImgUrls]=useState([]);

    const generateImg= async()=>{
        try {
          const response =  await fetch(`localhost:8081/generate-image?prompt=${promt}`)
          const url =await response.json();
          setImgUrls(urls)
        } catch (error) {
            console.error("Error generating Error image : ",error)
        }
    }
    return(
        <div>
            <h2>Generate Image hehe</h2>
            <input type="text" value={promt} placeholder="Enter prompt for the Image" onChange={(e)=>setPromt(e.target.value)} name="" id="" />
            <button onClick={generateImg}>Generate Image</button>
            <div className="img-grid">
                {imgUrls.map((url,index)=>(
                    <img src={url} key={index} alt={`Generated ${index}`} />
                ))}
                {[...Array(4-imgUrls.length)].map((_,index)=>(
                    <div key={index+ imgUrls.length} className="empty-image-slot"></div>
                ))}
            </div>

        </div>
    )
}
export default ImageGenerator;