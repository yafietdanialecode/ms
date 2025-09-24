import { Button } from "antd"


export default function LeftSideBar() {
    return <div
    style={{
        minWidth: '20rem',
        position: 'fixed',
        top: '0px',
        left: '0px',
        height: '100vh',
        background: 'white'
    }}
    >

        <Button type="primary">Click Here</Button>

    </div>
}