#基本命令
##常规操作
####配置git
git config --global user.name "panzhixiong"
git config --global user.email panzhixiong@example.com
git config --list 查看配置信息
####获取git仓库
#####在现有目录中初始化仓库：git init
该命令将创建一个名为 .git 的子目录，这个子目录含有你初始化的 Git 仓库中所有的必须文件，这些文件是 Git 仓库的骨干。 但是，在这个时候，我们仅仅是做了一个初始化的操作，你的项目里的文件还没有被跟踪。
如果是在一个已经存在文件的文件夹中执行git init，就应该要继续执行git add .实现对所有文件的跟踪，然后执行git commit提交。
#####克隆现有的仓库：git clone [url]
该命令是从git上获取项目，默认配置下远程 Git 仓库中的每一个文件的每一个版本都将被拉取下来。
比如：git clone https://github.com/pumzx/spring-test.git
git支持多种传输协议，除了上面的https://外，还可以使用git://或者ssh
####检查文件状态：git status
现在在目录下新增了一个README.md文件，使用git status命令查看
![1.PNG](https://upload-images.jianshu.io/upload_images/16845162-d2dfb2808d99c966.PNG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
README.md出现在Untracked files:底下，未跟踪的文件意味着 Git 在之前的快照（提交）中没有这些文件；Git 不会自动将之纳入跟踪范围
####跟踪新文件：git add
git add后面可以是一个目录，也可以是一个具体的文件名。如果想要跟踪所有的文件可以使用git add .
在这里，我使用git add .或者git add README.md都可以。然后使用git status查看文件状态。
![2.PNG](https://upload-images.jianshu.io/upload_images/16845162-57481a34fecaa0d0.PNG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
此时文件已经被跟踪，并且已暂存。
现在如果想要修改一个文件(pom.xml)，用git status看看是什么状态。
![3.PNG](https://upload-images.jianshu.io/upload_images/16845162-c941b80751547eb0.PNG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
发现pom.xml出现在Changes not staged for commit:下，说明跟踪的文件发生了改变，但是没有放入暂存区。要暂存此次更新可以使用git add命令。
git add是个多功能命令：可以用它开始跟踪新文件，或者把已跟踪的文件放到暂存区，还能用于合并时把有冲突的文件标记为已解决状态等。
使用git add pom.xml命令后状态如下：
![4.PNG](https://upload-images.jianshu.io/upload_images/16845162-b6df5dbe25e195e6.PNG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
现在两个文件都暂存了，下次提交时就会一并提交到仓库。
如果这个时候需要在修改pom.xml，需要再运行git add命令重新暂存pom.xml。
####提交更新：git commit
运行git commit后会启动文件编辑器输入提交说明（默认是vim），一般情况下是直接用-m选项来输入注释。
git commit -m "增加README.md项目说明，修改pom.xml中jdk版本"。提交后会显示是在提交到哪个分支下，提交的更新内容有哪些。
请记住，提交时记录的是放在暂存区域的快照。 任何还未暂存的仍然保持已修改状态，可以在下次提交时纳入版本管理。 每一次运行提交操作，都是对你项目作一次快照，以后可以回到这个状态，或者进行比较。
######跳过使用暂存区域：git commit -a
git 提供了一个跳过使用暂存区域的方式， 只要在提交的时候，给 git commit 加上 -a 选项，Git 就会自动把所有**已经跟踪过的文件**暂存起来一并提交，从而跳过 git add 步骤。如果是新建了文件，因为git没有跟踪过，所以还是需要使用git add命令来跟踪文件，然后再commit。
####删除文件：git rm
要从 Git 中移除某个文件，就必须要从已跟踪文件清单中移除（确切地说，是从暂存区域移除），然后提交。 可以用 git rm 命令完成此项工作，并连带从工作目录中删除指定的文件，这样以后就不会出现在未跟踪文件清单中了。
1.从工作目录中删除指定文件（此时运行 git status 时就会在 “Changes not staged for commit” 部分（也就是 未暂存清单）看到）:
rm test.txt
2.运行 git rm 记录此次移除文件的操作
git rm test.txt
3.运行git commit -m "delete test.txt"
如果删除之前修改过并且已经放到暂存区域的话，则必须要用强制删除选项 -f
git rm -f test.txt
如果你想让文件保留在磁盘，但是并不想让 Git 继续跟踪。 当你忘记添加 .gitignore 文件，不小心把一个很大的日志文件或一堆 .class 这样的编译生成文件添加到暂存区时，这一做法尤其有用。 为达到这一目的，使用 --cached 选项
git rm --cached t2.txt
这个时候再运行git status发现t2.txt出现在Untracked files:下。
git rm 命令后面可以列出文件或者目录的名字，也可以使用 glob 模式。
git rm log/\*.log   --删除log目录下所有扩展名为.log的文件
git rm \*~  --删除以~结尾的所有文件
####移动文件：git mv from to
文件重命名：
git mv file_from file_to
运行 git mv 就相当于运行了下面三条命令：
mv README.md README
git rm README.md
git add README
####撤销操作
#####重新提交：git commit --amend
提交后发现漏掉了未暂存的文件，先暂存，然后重新提交。最终只会算一个提交。
git commit -m 'initial commit'
git add forgotten_file
git commit --amend（也可以加上-m选项）
#####取消暂存的文件：git reset HEAD 
比如使用git add *暂存了所有文件（t1.txt和t2.txt），但是只想暂存t1.txt，所以需要撤销暂存t2.txt。
git reset HEAD t2.txt
现在t2.txt就到了未暂存状态
#####撤消对文件的修改：git checkout -- <file>
比如现在修改了t1.txt，但是想撤销到修改前的样子，就可以使用下面的命令来撤销：
git checkout -- t1.txt
需要知道的是 git checkout -- [file] 是一个危险的命令，这很重要。 你对那个文件做的任何修改都会消失 - 你只是拷贝了另一个文件来覆盖它。 除非你确实清楚不想要那个文件了，否则不要使用这个命令。
在 Git 中任何 已提交的 东西几乎总是可以恢复的。 甚至那些被删除的分支中的提交或使用 --amend 选项覆盖的提交也可以恢复
####查看提交历史：git log
git log 这个命令会列出每个提交的 SHA-1 校验和、作者的名字和电子邮件地址、提交时间以及提交说明。
git log -2 查看最近两次的提交记录
git log -p -2查看最近两次，每次提交的内容差异
--stat 选项在每次提交的下面列出额所有被修改过的文件、有多少文件被修改了以及被修改过的文件的哪些行被移除或是添加了。 在每次提交的最后还有一个总结。
--pretty 选项可以指定使用不同于默认格式的方式展示提交历史。这个选项有一些内建的子选项供你使用。 比如用 oneline 将每个提交放在一行显示，查看的提交数很大时非常有用。 另外还有**format**， short，full 和 fuller 可以用。
####添加远程仓库：git remote add <shortname> <url>
git remote add pb https://github.com/paulboone/ticgit
pb就是代替url的
####从远程仓库中抓取与拉取：git fetch <remote-name>
git fetch pb
拉取 Paul 的仓库中有但我本地没有的信息， 执行完成后，将会拥有那个远程仓库中所有分支的引用，可以随时合并或查看。
如果使用 clone 命令克隆了一个仓库，命令会自动将其添加为远程仓库并默认以 “origin” 为简写。 所以，git fetch origin 会抓取克隆（或上一次抓取）后新推送的所有工作。 必须注意 git fetch 命令会将数据拉取到本地仓库，但是它并不会自动合并或修改你当前的工作。 当准备好时必须手动将其合并入的工作。
####推送到远程仓库：git push [remote-name] [branch-name]
git push origin master
这个命令会把我在本地做的备份（commit内容）推送到服务器上。
**如果有其他人也拉取了这个远程仓库，然后他们先推送内容到远程仓库，那么我现在必须先将他们推送的内容拉取下来并合并进我的工作后才能推送。**
####查看远程仓库：git remote show [remote-name]
git remote show origin
![5.PNG](https://upload-images.jianshu.io/upload_images/16845162-a46337522bdb0f51.PNG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
####远程仓库的移除与重命名:git remote rename from to |  git remote rm
重命名远程仓库引用的名字：git remote rename pb paul
重命名后，分支的名字也会修改。 那些过去引用 pb/master 的现在会引用 paul/master。
移除远程仓库：git remote rm paul
##打标签-标记发布节点
####列出标签：git tag
git tag -l 'v1.8*' :只会；列出1.8系列的标签。（-l和*号就是通配查询）
####创建标签
Git 使用两种主要类型的标签：轻量标签（lightweight）与附注标签（annotated）。
一个轻量标签很像一个不会改变的分支 - 它只是一个特定提交的引用。（临时标签）
**附注标签**是存储在 Git 数据库中的一个完整对象。 它们是可以被校验的；其中包含打标签者的名字、电子邮件地址、日期时间；还有一个标签信息；并且可以使用 GNU Privacy Guard （GPG）签名与验证。 通常建议创建附注标签，这样你可以拥有以上所有信息。
####轻量标签：git tag
git tag v1.0-lw
git show v1.0-lw看不到啥消息
####附注标签：git tag -a <tag-name> -m 'tag-info'
创建一个付诸标签：
git tag -a v1.0 -m 'my version 1.0'
查看标签信息与对应的提交信息：
git show v1.0
####后期打标签:git tag -a <tag-name> <校验和>
先用git log --pretty=oneline查看提交历史（第一列就是校验和），然后在某一次提交上打标签
git tag -a v1.1 0f18e592f85f46a20cb2e960ca339f6939367ea2
####共享标签：git push origin [tagname]
默认情况下，git push 命令并不会传送标签到远程仓库服务器上。 在创建完标签后你必须显式地推送标签到共享服务器上。 这个过程就像共享远程分支一样 - 可以运行git push origin [tagname] 。
git push origin v1.0
如果想要一次性推送很多标签，也可以使用带有 --tags 选项的 git push 命令。 这将会把所有不在远程仓库服务器上的标签全部传送到那里。
####检出标签
在 Git 中并不能真的检出一个标签，因为它们并不能像分支一样来回移动。 如果想要工作目录与仓库中特定的标签版本完全一样，可以使用 git checkout -b [branchname] [tagname] 在特定的标签上创建一个新分支：
git checkout -b dev v1.0
####Git 别名
设置git命令的别名
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.st status
git config --global alias.unstage 'reset HEAD --'  
git unstage fileA  等价于  git reset HEAD -- fileA
git config --global alias.last 'log -1 HEAD' 添加一个last命令查看最后一次提交

#Git分支

