import React, { useState } from "react";

function Chat(){
    const[prompt,setPromt] = useState('');
    const[chatResponse,SetChatResponse]= useState('');
    
    const askAi=async()=>{
        try {
         const response = await fetch(`localhost:8081/ask-ai-options?prompt=${prompt}`)  
         const url = await response.text();
         console.log(url);
         SetChatResponse(url); 
        } catch (error) {
            console.error("Error in generating response ",error)
        }
    }

    return(
        <div>
  <h2>Talk to AI</h2>
  <input type="text" value={prompt} onChange={(e)=>setPromt(e.target.value)} placeholder="Enter a prompt for AI"  />
   <button onClick={askAi}>Ask AI</button>
   <div className="output">
    <p>{chatResponse}</p>
   </div>
        </div>
       
      
    )
}
export default Chat;