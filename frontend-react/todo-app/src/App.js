import './App.css';
import { Component } from 'react' // class component를 사용하기 위해 import처리

function App() {
  return (
    <div className="App">
      {/* Lia's First Todo */}
      <FirstComponent />
      <SecondComponent />
      <ThirdComponent />
      <FourthComponent />
    </div>
  );
}

function FirstComponent() {
  return (
    <div className="FirstComponent">
      First Component
    </div>
  )
}

function SecondComponent() { // function component
  return (
    <div className="SecondComponent">
      Second Component
    </div>
  )
}

class ThirdComponent extends Component { // class Component
  render() { // class Component에서는  render 사용. 렌더링 메서드는 컴포넌트 일부로 보여주고 싶은 텍스트 반환
    return (
      <div className="ThirdComponent">Third Component</div>
    )
  }

}

class FourthComponent extends Component {
  render() {
    return ( // 낱개로 반환은 불가하나 빈태그로 묶어서 반환 가능
      <>
        <div className="Fourth"> Fourth Component </div>
        <div className="Fourth"> Fourth Component </div>
      </>
    )
  }
}

export default App;
