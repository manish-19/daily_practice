git init
git add .
git status
git commit  -m "some commit"
git push origin main
git pull
git log

For SSh:
ssh-keygen -t rsa -b 4096 -C "email"
add the generated key from user .ssh file in create new ssh
eval $(ssh-agent -s)
ssh -T git@github.com

For Branching
git branch [branch-name]
git checkout -b 'branch-name'
git push -u [origin] [branch]
git branch -r

Merges,Pull requests and Conflicts Refer:
[https://app.pluralsight.com/course-player?clipId=53f32184-eaa2-4630-81f7-9ed9cc49c685]

Reference Website:
[https://www.w3schools.com/git/default.asp?remote=github]
[https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html]