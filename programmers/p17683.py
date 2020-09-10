def solution(m, musicinfos):
    answer = ''
    music_info = {}
    m = replaceSharp(m)
    
    for music in musicinfos:
        m_info = music.split(',')
        m_time = get_time(m_info[0], m_info[1])
        m_title = m_info[2]
        m_music = m_info[3]
        m_music = replaceSharp(m_music)
        
        #print(m_music)
        origin_music = m_music
        playtime = len(m_music)
        
        if m_time < len(m):
            continue
        if m_time < playtime:
            m_music = m_music[:m_time]
        elif m_time > playtime:
            l = len(m_music)
            r = m_time//l
            musi = m_music
            for a in range(1, r):
                m_music += musi
            m_t = m_time%l        
            if m_t > 0:
                m_music += musi[:m_t]
        music_info[m_title] = m_time
        #print(m_music)
        if m in m_music:
            if len(answer) == 0:
                answer = m_title
            else:
                #print(m_time, music_info[answer])
                if m_time > music_info[answer]:
                    answer = m_title
    if answer == '':
        answer = "(None)"
    return answer

def get_time(start, end):
    s = start.split(':')
    e = end.split(':')
    
    time = [0, 0]
    time[0] = int(e[0]) - int(s[0])
    time[1] = int(e[1]) - int(s[1])
    
    return time[0]*60 + time[1]


def replaceSharp(m_music):
    m_music = m_music.replace('C#', 'c')
    m_music = m_music.replace('D#', 'd')
    m_music = m_music.replace('F#', 'f')
    m_music = m_music.replace('G#', 'g')
    m_music = m_music.replace('A#', 'a')
    m_music = m_music.replace('B#', 'b')

    return m_music
