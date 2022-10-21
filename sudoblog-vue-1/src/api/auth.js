const TokenKey = 'token'

export function getToken () {
  return localStorage.getItem(TokenKey)
}

export function setToken (token) {
  return localStorage.setItem(TokenKey, token)
}

export function removeToken () {
  return localStorage.removeItem(TokenKey)
}
const dialogVisible = 'dialog'

export function getDialogVisible () {
  return localStorage.getItem(dialogVisible)
}

export function setDialogVisible (dia) {
  return localStorage.setItem(dialogVisible, dia)
}

export function removeDialogVisible () {
  return localStorage.removeItem(dialogVisible)
}
const UserInfo = 'userInfo'

export function getUserInfo(){
  return localStorage.getItem(UserInfo)
}
export function setUserInfo(userInfo){
  return localStorage.setItem(UserInfo,userInfo)
}
export function removeUserInfo(){
  return localStorage.removeItem(UserInfo)
}
const isAdmin = 'admin'

export function getIsAdmin(){
  return localStorage.getItem(isAdmin)
}
export function setIsAdmin(admin){
  return localStorage.setItem(isAdmin,admin)
}
export function removeIsAdmin(){
  return localStorage.removeItem(isAdmin)
}
const fromPath = '/'

export function getFromPath(){
  return localStorage.getItem(fromPath)
}
export function setFromPath(path){
  return localStorage.setItem(fromPath,path)
}
export function removeFromPath(){
  return localStorage.removeItem(fromPath)
}
