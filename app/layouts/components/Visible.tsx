'use client'
import Device from "@/layouts/device";
import LeftSideBar from "@/layouts/LeftSideBar";
import { useEffect, useState } from "react";
import { DEVICE_TYPES } from "../config";




export default function Visible(props: { children: any, type: 'match' | 'except', list: DEVICE_TYPES[] }) {

    const [device, setDevice] = useState(new Device());
    const [render, setRender] = useState(false);
    const [windowWidth, setWindowWidth] = useState(0);
    const [windowHeight, setWindowHeight] = useState(0)


    useEffect(() => {
        setDevice(new Device())
        setRender(true)

        window.addEventListener('resize', () => {
            setWindowHeight(window.innerHeight);
            setWindowWidth(window.innerWidth);
        });

    }, [])

    useEffect(() => {
        setDevice(new Device());
    }, [windowWidth, windowHeight])

    if (render) {
        if (props.type === 'match') {
            if (device.match(props.list)) {
                return <>
                    {props.children}
                </>
            }

        } else if (props.type === 'except') {
            if (device.except(props.list)) {
                return <>
                    {props.children}
                </>
            }
        }
    }

}