// layout related configs will be here

export type DEVICE_TYPES = 'watch' | 'mobile' | 'tablet' | 'desktop' | 'watch' | undefined;


export class LayoutConfig {

public configs = {
    device: {
        watch: {
            width: { min: 0, max: 399 },
            height: { min: 0, max: 399 }
        },
        mobile: {
            width: { min: 400, max: 767 },
            height: { min: 0, max: 1024 }
        },
        tablet: {
            width: { min: 768, max: 1024 },
            height: { min: 0, max: 1366 }
        },
        laptop: {
            width: { min: 1025, max: 1366 },
            height: { min: 0, max: 900 }
        },
        desktop: {
            width: { min: 1367, max: 1364444447 },
            height: { min: 0, max: 136744444444 }
        }
    }
};
    

}
