import httpService from '@/libs/http'

const api = 'https://www.baidu.com'

export default {
    test() {
        return httpService.get( api, {}, 'GET')
    }
}