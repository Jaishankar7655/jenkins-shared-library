def call(url , branch){
 echo 'Cloning the code'
 git url: "${url}" , branch: "${branch}"
 echo 'cloned successfully' 
}
