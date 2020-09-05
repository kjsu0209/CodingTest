# 0:55
import re
def solution(word, pages):
    answer = 0
    data = []
    data_map = {}
    link_store = {}
    word = word.lower()
    r = re.compile("^" + word + "$")

    for p in pages:
        html = re.split('[<>]', p)
        body_start = False
        d = []
        link_arr = []
        meta = ''
        for h in html:
            if 'meta property' in h:
                meta = re.split("\"", h)[3]
                data_map[meta] = len(data)
                d = [len(data), 0, 0]
            elif 'body' == h:
                if body_start == False:
                    body_start = True
            elif '/body' == h:
                    body_start = False
            elif 'a href="' in h and body_start == True:
                link = re.split("\"", h)[1]
                #print('link:',link)
                link_arr.append(link)
                        
            elif body_start == True and '/a' != h:
                #print('body: ' , h)
                h = h.lower()
                contents = re.sub('[0-9-=+,#/\?:^$.@*\"※~&%ㆍ!』\\‘|\(\)\[\]\<\>`\'…》\n\t]', ' ', h)
                contents = contents.split(' ')
                c = len(list(filter(r.findall, contents)))
                d[1] += c
        
        # link
        for link_item in link_arr:
            if link_item in link_store.keys():
                link_store[link_item] += d[1]/len(link_arr)
            else:
                link_store[link_item] = d[1]/len(link_arr)
        data.append(d)
        
    for l, v in link_store.items():
        if l in data_map.keys():
            data[data_map[l]][2] = v
    
    data = sorted(data, key=lambda x: (x[1]+x[2]), reverse=True)
    answer = data[0][0]
    return answer
