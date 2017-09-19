package fb;

public class Design {
/**
 * 设计一个 hack pokemon go的 app。 用户不用出门就能抓到pokemon [done]
 * 系统：  一千个机器， 维基百科 爬虫问题， 机器网络很差，然后每个网页只能爬一边  [done]
 * 后面加试一轮系统。 类似于top10 ranking. [none]
 * design POI http://massivetechinterview.blogspot.com/2015/06/poi-geohash.html [done]
   我当时答geohash是可以的，剩下的就是sql存，找公共前缀，然后再是算空间，机器数，再就是怎么sharding 分布式，
   建index找，pre/cache result，底层怎么存。 整个flow差不多就是这样，中间有些细节和面试官讨论了下。
 * 设计 instagram [done]
 * 设计一个FB的搜索系统， 自我感觉讨论不错， 然并卵 
	从requriment开始： 要搜索什么？ people,post, event ....
	constraint ， 用户多少，数据多少之类；
	UI 怎么搞， 怎样提高用户体验， typehead, 不同label分类
	总体怎么设计， 前段， server， 数据，画一画.
	workflow 怎样，写个流程， 一个请求怎么完成 .
	webservice怎么设计？ API， operation是怎么定义， 把restful讲讲
	数据库， 搜索的数据结构都怎么存，SQL table啦，还有 trie啦， bloom filter 啦， inverted table都讲讲。  
	CAP那一套说一说，怎么balance， 怎么Partion， 怎么保证consistence, cache怎么存
 * design, privacy setting, 就是被everyone可见，只被朋友的朋友可见，group可见，[done]
	 问底层SQL怎么存（每一column是什么，怎么Join)，问存friend mapping怎么存，
	 用SQL存和用noSQ存friend mapping的trade off. 然后问friend of friend怎么找，
	 之前看过面经，直接说出最基本的n^2和两种O(n)方法，结果没一种是面试官想要，
	 只能跟着面试官的提示走，一路看面试官的语气、表情、以及对我提出方案的反应，
	 揣测面试官想要的解法。之后就是判断需要多少server存等，整个感觉就是被面试官带着飞的感觉
	 
	 面试官先让我说怎么存用户数据，我基本就是照着他们tao那个paper的思路说的，然后问了一些saclability的问题，
	 不是特别深入，就是sharding，replication，consistent hashing什么的，然后问怎么优化privacy setting，
	 我提出的做法貌似跟他们的做法不一致，然后他提醒了我一下，我就按照他提醒的思路说了，具体他怎么提醒的，
	 以及后来我怎么说的其实lz也忘了，因为我当时的确没太理解他们为啥那么设计，不过按照面试官的思路说总不会出错的。。。

	 http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=283571
 * FTP client 给 server 传输文件 的系统。 一个/多个clients <-> 一个／多个 server [none]
 * 设计是 news API design, 也是面经了。   注意 pagination. 看看twitter 的 API developer's guide 会有帮助。 
 * tinyurl
 * sum up: http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=289293
 * 设计FB event reminder， 就是允许用户设置在事件发生之前多长时间发出提醒， 主要是讲怎么扩展数据库
 * Event Reminder
	这是一个典型的 Producer Consumer 模型。除了 Event Table 以外，我们需要一个 Notification Table。这个 Notification Table 记录的就是需要在什么时间，
	通知谁，什么事情，这一次性通知的，还是循环通知，如果是循环通知，那么循环规则是什么。 Notification Table 按照需要通知的时间进行排序。
	先说如果 event少的 work solution 是什么：用一个进程，每隔 5s 扫一下这个table，不是线性扫描，而是 select 一下有哪些 Notification 的时间 小于 了当前时间。
	然后把需要通知的一个个通知。
	如果需要通知的event很多，怎么处理？
	一个人干不完的活，多个人干。如果通知特别多的话，我们就 sharding 呗。如果我们不需要支持删除一条 Notication 的话，我们甚至可以随意分给多个机器就好了。
	但这个问题中，不容易发现的是，如果我取关了一个 Event，需要把我的 Notification 删除。所以我们 sharding 的时候，应该按照被提醒的用户的 user_id 进行 sharding。
	这样才能在需要删除的时候，还能再找回来。
	Sharding 完以后，每个负责发提醒任务的进程就专门负责一个 sharding block 里的数据的提醒。
	如果一个用户创建那种每星期1下午3点都有的event，应该怎么建table？
	在前面的 Notification Table 的定义中，我已经给出答案了。基本思想就是，一条 notification 记录着下一次需要提醒的时间是什么，然后当这个 notification 被提醒之后，
	如果是一次性的，就直接扔掉了，如果是循环的，那么就根据循环规则计算出下一次需要提醒的时间，然后重新丢回 Notification Table 中。
 * system design: design messengers's online/offline status.
 * 如何design一个在facebook上make comment的method，一个人发comment，同时在网页上浏览的人都能看到
 * Design fb inbox search    —> just focus the post
 * https://github.com/donnemartin/system-design-primer
 * design a memcache，给出了内存空间要求，其余的数据量大小要你自己问
 * Typeahead 1. top n hot key word怎么生成，问了下map reduce的东西 
	  2. typeAhead这里的hot key words考虑多久的时效性，比如你是按照1 month，1 week，1 day 
	  还是1 hour的数据给出hot key words。3. 大家都知道要用Trie去存数据，
	  并且Trie是放在cache里的，那么这个cache什么时候去更新？怎么更新？要不要加TTL？
	  你更新的这个cache的频率会对用户query的时效性产生很大的影响，并且你更新也会对数据库和服务器造成额外的负担，
	  你怎么去平衡。最后加了一个问题说如果这个服务是面向多个国家的，过了一段时间你发现你的推荐在某些国家点击率很高，
	  有些国家点击率很低，你要怎么优化。http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=280598
  * roomba
  * 


 */
}
