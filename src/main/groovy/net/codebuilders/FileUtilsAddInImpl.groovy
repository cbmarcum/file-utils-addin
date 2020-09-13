package net.codebuilders

import com.sun.star.uno.XComponentContext
import com.sun.star.lib.uno.helper.Factory
import com.sun.star.lang.XSingleComponentFactory
import com.sun.star.registry.XRegistryKey
import com.sun.star.lib.uno.helper.WeakBase
import org.apache.commons.io.FilenameUtils

@groovy.transform.CompileStatic
final class FileUtilsAddinImpl extends WeakBase
implements com.sun.star.lang.XServiceInfo,
com.sun.star.lang.XLocalizable,
net.codebuilders.XFileUtilsAddin {
    private final XComponentContext m_xContext
    private static final String m_implementationName = FileUtilsAddinImpl.class.getName()
    private static final String[] m_serviceNames = ["net.codebuilders.FileUtilsAddin"] as String[]

    private com.sun.star.lang.Locale m_locale = new com.sun.star.lang.Locale()

    FileUtilsAddinImpl( XComponentContext context ) {
        m_xContext = context
    }

    static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null

        if ( sImplementationName.equals( m_implementationName ) )
        xFactory = Factory.createComponentFactory(FileUtilsAddinImpl.class, m_serviceNames)
        return xFactory
    }

    static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
            m_serviceNames,
            xRegistryKey)
    }

    // com.sun.star.lang.XServiceInfo:
    String getImplementationName() {
        return m_implementationName
    }

    boolean supportsService( String sService ) {
        int len = m_serviceNames.length

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
            return true
        }
        return false
    }

    String[] getSupportedServiceNames() {
        return m_serviceNames
    }

    // com.sun.star.lang.XLocalizable:
    void setLocale(com.sun.star.lang.Locale eLocale) {
        m_locale = eLocale
    }

    com.sun.star.lang.Locale getLocale() {
        return m_locale
    }

    // net.codebuilders.XFileUtilsAddin:
    String fileBasename(String parameter0) {
        String result = FilenameUtils.getBaseName(parameter0)
        return result
    }

    String fileExtension(String parameter0) {
        String result = FilenameUtils.getExtension(parameter0)
        return result
    }

    String filePath(String parameter0) {
        String result = FilenameUtils.getFullPath(parameter0)
        return result
    }

}