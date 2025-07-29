import React, { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ImageGenerator from './component/ImageGenerator';
import Chat from './component/Chat';
import RecipeGenerator from './component/RecipeGenerator';

function App() {
  const[activeTab,setActiveTab] =useState('image-generator');

  const handleChnage =(tab)=>{
    alert(tab);
    setActiveTab(tab);
  }

  return (
    <>
      <div>
        <button className={activeTab ==='image-generator' ? 'active' : ''}
        onClick={()=>handleChnage('image-generator')}>Image Generator</button>

        <button className={activeTab ==='chat' ? 'active' : ''}
         onClick={()=>handleChnage('chat')}>Chat</button>

        <button className={activeTab ==='recipe-generator' ? 'active' : ''}
         onClick={()=>handleChnage('recipe-generator')}>Recipe Generator</button>

      </div>
      <div>
        {activeTab==='image-generator' && <ImageGenerator/>}
        {activeTab==='chat' && <h2><Chat/></h2>}
        {activeTab==='recipe-generator' && <h2><RecipeGenerator/></h2>}
      </div>
      
    </>
  )
}

export default App
