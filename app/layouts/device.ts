import { DEVICE_TYPES, LayoutConfig } from "./config";



export default class Device {

    private configs: any;

    constructor() {
        this.configs = new LayoutConfig().configs;
    }

    public getDeviceType() {
        const width = window.innerWidth;
        const height = window.innerHeight;
    }


    public isWatch(width: number, height: number) {
        if(this.configs.device.watch.width.max > width && this.configs.device.watch.width.min < width) {
            return true;
        } else {
            return false;
        }
    }

    public isMobile(width: number, height: number) {
        if(this.configs.device.mobile.width.max > width && this.configs.device.mobile.width.min < width) {
            return true;
        } else {
            return false;
        }
    }

    public isTablet(width: number, height: number) {
        if(this.configs.device.tablet.width.max > width && this.configs.device.tablet.width.min < width) {
            return 'tablet';
        } else {
            return false;
        }
    }

    public isDesktop(width: number, height: number) {
        if(this.configs.device.desktop.width.max > width && this.configs.device.desktop.width.min < width) {
            return 'desktop';
        } else {
            return false;
        }
    }


    public findDevice(width: number, height: number): DEVICE_TYPES {
        if(this.isWatch(width, height)) {
            return 'watch';
        } else if(this.isMobile(width, height)) {
            return 'mobile';
        } else if(this.isTablet(width, height)) {
            return 'tablet';
        } else if(this.isDesktop(width, height)) {
            return 'desktop'
        } else
            return undefined;
    }

    public type(): DEVICE_TYPES {
        const width = window.innerWidth;
        const height = window.innerHeight;
        return this.findDevice(width, height);
    }

    public match(types: DEVICE_TYPES[]) {
        const width = window.innerWidth;
        const height = window.innerHeight;
        const deviceType: DEVICE_TYPES = this.findDevice(width, height);
        return types.some((ofThem) => ofThem === deviceType);
    }

    public except(types: DEVICE_TYPES[]) {
        const width = window.innerWidth;
        const height = window.innerHeight;
        const deviceType: DEVICE_TYPES = this.findDevice(width, height);
        return types.every((ofThem) => ofThem !== deviceType);
    }

}